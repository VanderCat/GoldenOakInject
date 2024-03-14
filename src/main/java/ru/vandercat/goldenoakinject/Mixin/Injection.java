package ru.vandercat.goldenoakinject.Mixin;

import com.mojang.authlib.Environment;
import com.mojang.authlib.yggdrasil.YggdrasilEnvironment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.vandercat.goldenoakinject.GoldenOakInjection;

@Mixin(YggdrasilEnvironment.class)
public class Injection {


    @Inject(method = "getEnvironment", at=@At("TAIL"), cancellable = true, remap=false)
    public void getEnvironment(CallbackInfoReturnable<Environment> cir) {
        cir.setReturnValue(GoldenOakInjection.NewAuth);
    }
}
