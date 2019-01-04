package utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Yaroslav Nazarov
 */
public interface Resetable {
    /**
     * Removes global impact of the instance's existence. If the instance is 
     * still used, it would likely make the program incorrect!
     */
    public void reset();
}
