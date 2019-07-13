/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appletguia3;

/**
 *
 * @author camilo
 */
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class AppletGuia3 extends Applet implements ActionListener {
TextField tfEstatura,tfPeso, tfGenero,tfMensaje;//entradas de texto
Label lEstatura,lPeso, lGenero;//label de los textos de entrada
Button boton;
double resultado = 0;//variable para mostrar el resultado
//método constructor,donde se crean los objetos a dibujar en el applet
public AppletGuia3() {
//Damos la instruccion que no se usará ningun layout para poder dibujar con setBounds
this.setLayout((null));
//setBounds(posicionx, posiciony, ancho, alto)
lEstatura= new Label("Estatura (mt): ");
lEstatura.setBounds(20, 20, 100, 20);
lPeso= new Label("Peso (kg): ");
lPeso.setBounds(20, 40, 100, 20);
lGenero=new Label("Genero : ");
lGenero.setBounds(20, 60, 100, 20);
tfEstatura = new TextField();
tfEstatura.setBounds(120, 20, 100, 20);
tfPeso = new TextField();
tfPeso.setBounds(120, 40, 100, 20);
tfGenero = new TextField();
tfGenero.setBounds(120, 60, 100, 20);
tfMensaje = new TextField();
tfMensaje.setBounds(20,160,200,20);
boton = new Button("Calcula");
boton.setBounds(120,100,100,20);
//agregamos los elementos a la pantalla
add(lEstatura);
add(lPeso);
add(lGenero);
add(tfEstatura);
add(tfPeso);
add(tfGenero);
add(tfMensaje);
add(boton);
 boton. addActionListener(this); // se le añade al boton la facilidad de
// ser escuchado

}


//método paint en el cual se pone lo que se quiere dibujar
public void paint(Graphics g) {
this.setSize(300, 300);

g.drawString("Su Indice de Masa corporal es = "+resultado, 20, 140);

//dibuja el cuadrado
}
// método para realizar las opciones al oprimir un botón
public void actionPerformed(ActionEvent ae) {
    // se toma el numero del texto y se pasa a la variable numes
double numes = Double.parseDouble(tfEstatura.getText());
// se toma el numero del texto y se pasa a la variable numpes
double numpes = Double.parseDouble(tfPeso.getText());
double r = (numpes)/(numes*numes);

resultado = r;
System.out.println(resultado);

String genero=(tfGenero.getText());
switch(genero){
    case "hombre":
        if (resultado<20)
        tfMensaje.setText("Bajo Peso");
        else if (resultado>=20&&resultado<=24.9)
        tfMensaje.setText("Normal");
        else if (resultado>=25&&resultado<=29.9)
        tfMensaje.setText("Obesidad Leve");
        else if (resultado>=30&&resultado<=40)
        tfMensaje.setText("Obesidad Severa");
        else if (resultado>40)
        tfMensaje.setText("Obesidad muy severa");
        break;
    case "mujer":
        if (resultado<20)
        tfMensaje.setText("Bajo Peso");
        else if (resultado>=20&&resultado<=23.9)
        tfMensaje.setText("Normal");
        else if (resultado>=24&&resultado<=28.9)
        tfMensaje.setText("Obesidad Leve");
        else if (resultado>=29&&resultado<=37)
        tfMensaje.setText("Obesidad Severa");
        else if (resultado>37)
        tfMensaje.setText("Obesidad muy severa");
        break;
    default:
        tfMensaje.setText("Error en Genero");
}

}
}