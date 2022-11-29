package org.hostile.anticheat.check.impl.autoclicker;

import org.hostile.anticheat.check.annotation.CheckMetadata;
import org.hostile.anticheat.check.type.impl.AutoClickerCheck;
import org.hostile.anticheat.data.PlayerData;
import org.hostile.anticheat.util.MathUtil;

@CheckMetadata(type = "AutoClicker", name = "A")
public class AutoClickerA extends AutoClickerCheck {

    public AutoClickerA(PlayerData playerData) {
        super(playerData);
    }

    @Override
    public void handle() {
        double cps = MathUtil.getCps(clicks);

        if (cps > 30) { //kick for excessively high CPS
            if (incrementBuffer(1) > 3) {
                fail("cps", cps);
            }
        } else {
            decrementBuffer(0.5);
        }
    }

    @Override
    public int getSampleSize() {
        return 100;
    }
}