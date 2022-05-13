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
    private double totalSinIVAconDescuento;
    private double IVA;
    private double totalPVP;
    private boolean descuentoRecogidaLocal;
    private int cuantasSalsas;
    
    private String tipoHamburguesa;
    private String tipoPan;
    private String tipoPatatas;
    private String tipoBebida;
    private String extra1="";
    private String extra2="";
    private String extra3="";
    private String envioORecogida;
    
    private ArrayList<Producto> productos= new ArrayList<>();
    
    //Constructor
    public Controlador() {
        totalSinIVA=0;
        totalSinIVAconDescuento=totalSinIVA;
        IVA=0.21*totalSinIVAconDescuento;
        totalPVP=totalSinIVAconDescuento+IVA;
    }
    
    //-----------------GETTERS ----------------------------
    public double getTotalSinIVA() {
        //Cada vez que se quiera ver el total se actualiza
        totalSinIVA=8;
        for(Producto p: productos){
            totalSinIVA+=p.getPrecio();
        }
        return totalSinIVA;
    }
    
    public double getTotalSinIVAconDescuento() {
        //Cada vez que se quiera ver el total se actualiza aplicando o no el descuento
        totalSinIVAconDescuento= getTotalSinIVA();
        if(descuentoRecogidaLocal){
            totalSinIVAconDescuento=totalSinIVAconDescuento*0.8;
            return totalSinIVAconDescuento;
        } 
        return totalSinIVA;
    }
    
    public double getDescuento(){
        if(descuentoRecogidaLocal){
            return -(totalSinIVAconDescuento*0.2);
        }else{
            return 0;
        } 
    }

    public double getIVA() {
        IVA=0.21*getTotalSinIVAconDescuento();
        return IVA;
    }
    
    public double getExtrasMenu(){
        double extrasmenu=0;
        for(Producto p: productos){
            if(p.getNombreProducto().equals("ternera") || p.getNombreProducto().equals("vegana")
                    || p.getNombreProducto().equals("caseras") || p.getNombreProducto().equals("panSinGluten")){
                extrasmenu+=p.getPrecio();
            }
        }
        return extrasmenu;
    }
    
    public double getExtrasOpcionales(){
        double extrasOpcionales=0;
        for(Producto p: productos){
            if(p.getNombreProducto().equals("extraQueso") || p.getNombreProducto().equals("extraPapas")
                    || p.getNombreProducto().equals("burgerDoble")){
                extrasOpcionales+=p.getPrecio();
            }
        }
        return extrasOpcionales;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public boolean isDescuentoRecogidaLocal() {
        return descuentoRecogidaLocal;
    }
    
    public double getPVPfinal() {
        totalPVP=getTotalSinIVAconDescuento()+getIVA();
        return totalPVP;
    } 

    public String getResumenPedido() {
        return "Resumen del pedido:"
                + "\n-------------------------------"
                + "\nHamburguesa "+tipoHamburguesa
                + "\nPan................... "+tipoPan
                + "\nGuarnición...... "+tipoPatatas
                + "\nBebida............. "+tipoBebida
                + "\nExtras.............. "+extra1+extra2+extra3
                + "\nSalsas............ "+cuantasSalsas
                + "\n-------------------------------"
                + "\n"+envioORecogida
                + "\n-------------------------------"
                + "\nTotal............... "+String.format("%.2f", getPVPfinal())+" €\n";
        
    }
    
    //--------------- AÑADIR Y BORRAR PRODUCTOS ----------------
    public boolean addProducto(Producto p){
        for(Producto prod: productos){
            if(prod.getNombreProducto().equals(p.getNombreProducto())){
                //Si ya está en la lista no se añade
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
        //Si no lo encuentra no borra nada y devuelve false
        return false;
    }

    public double getPrecioSalsas(int numSalsas){
        cuantasSalsas=numSalsas;
        double precio = numSalsas*0.50;
        return precio;
    }
    
    public void setDescuentoRecogidaLocal(boolean siNo){
        descuentoRecogidaLocal=siNo;
    }
    
    //------------ SETTERS DE TIPOS DE PRODUCTO ------------

    public void setTipoHamburguesa(String tipoHamburguesa) {
        this.tipoHamburguesa = tipoHamburguesa;
    }

    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }

    public void setTipoPatatas(String tipoPatatas) {
        this.tipoPatatas = tipoPatatas;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }
    
    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }
    
    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    public void setEnvioORecogida(String envioORecogida) {
        this.envioORecogida = envioORecogida;
    }
    
    
    
}
