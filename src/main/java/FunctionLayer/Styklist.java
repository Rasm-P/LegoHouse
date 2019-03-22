/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Rasmus2
 */
public class Styklist {
    private float TotalWithHeigth2x4;
    private float TotalWithHeigth2x2;
    private float TotalWithHeigth1x2;
    private float TotalWindows2x2;
    private float TotalDoors3x2;

    public Styklist(float TotalWithHeigth2x4, float TotalWithHeigth2x2, float TotalWithHeigth1x2, float TotalWindows2x2, float TotalDoors3x2) {
        this.TotalWithHeigth2x4 = TotalWithHeigth2x4;
        this.TotalWithHeigth2x2 = TotalWithHeigth2x2;
        this.TotalWithHeigth1x2 = TotalWithHeigth1x2;
        this.TotalWindows2x2 = TotalWindows2x2;
        this.TotalDoors3x2 = TotalDoors3x2;
    }

    public float getTotalWithHeigth2x4() {
        return TotalWithHeigth2x4;
    }

    public float getTotalWithHeigth2x2() {
        return TotalWithHeigth2x2;
    }

    public float getTotalWithHeigth1x2() {
        return TotalWithHeigth1x2;
    }

    public float getTotalWindows2x2() {
        return TotalWindows2x2;
    }

    public float getTotalDoors3x2() {
        return TotalDoors3x2;
    }
    
    
}
