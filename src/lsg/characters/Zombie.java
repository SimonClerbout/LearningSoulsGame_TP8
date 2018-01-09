package lsg.characters;

import lsg.weapons.Hand;

/**
 * Created by sclerbou on 09/01/18.
 */
public class Zombie extends Monster {

    public Zombie(){

        super("Zombie");
        this.setWeapon(new Hand());

    }

}
