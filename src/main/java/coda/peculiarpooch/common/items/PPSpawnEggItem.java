package coda.peculiarpooch.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class PPSpawnEggItem<T extends Entity> extends SpawnEggItem {
    public static final Set<PPSpawnEggItem<?>> SPAWN_EGGS = new HashSet<>();
    public final Lazy<EntityType<T>> type;

    @SuppressWarnings("ConstantConditions")
    public PPSpawnEggItem(Supplier<EntityType<T>> type, int primaryColor, int secondaryColor, Properties properties) {
        super(null, primaryColor, secondaryColor, properties);

        this.type = Lazy.of(type);
        SPAWN_EGGS.add(this);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundNBT childTag = tag.getCompound("EntityTag");
            if (childTag.contains("id", 8))
                return EntityType.byString(childTag.getString("id")).orElse(type.get());
        }

        return type.get();
    }
}