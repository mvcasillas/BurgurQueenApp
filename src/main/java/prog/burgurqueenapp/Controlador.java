/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.burgurqueenapp;

import java.util.ArrayList;


/**
 *
 * @author maria
 */
public class Controlador {
    private double totalSinIVA;
    private double IVA;
    private double totalConIVA;
    
    private ArrayList<Producto> productos= new ArrayList<>();

    public Controlador() {
        totalSinIVA=0;
        IVA=0.21*totalSinIVA;
        totalConIVA=totalSinIVA+IVA;
    }

    public double getTotalSinIVA() {
        totalSinIVA=8;
        for(Producto p: productos){
            totalSinIVA+=p.getPrecio();
        }
        return totalSinIVA;
    }

    public double getIVA() {
        IVA=0.21*totalSinIVA;
        return IVA;
    }

    public double getTotalConIVA() {
        totalConIVA=totalSinIVA*1.21;
        return totalConIVA;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public boolean addProducto(Producto p){
        for(Producto prod: productos){
            if(prod.getNombreProducto().equals(p.getNombreProducto())){
                return false;
            }
        }
        productos.add(p);
        return true;
    }
    
    public boolean addSalsas(Producto p){
        for(Producto prod: productos){
            if(prod.getNombreProducto().equals(p.getNombreProducto())){
                //Si ya existe el producto salsas, lo actualiza
                prod.setPrecio(p.getPrecio());
                return true;
            }
        }
        //Si no encuentra el producto salsas, lo añade
        productos.add(p);
        return true;
    }
    
    public boolean removeProducto(String nombreProducto){
        for(Producto p: productos){
            if(p.getNombreProducto().equals(nombreProducto)){
                productos.remove(p);
                return true;
            }
        }
        return false;
    }
    
 
    
    public double getPrecioSalsas(int numSalsas){
        double precio = numSalsas*0.50;
        return precio;
    }
    
    
    
}
