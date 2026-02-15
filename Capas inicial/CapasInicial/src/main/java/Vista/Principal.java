/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //insert
        Empresa empresa = new Empresa("Helados Sarita");
        System.out.println(empresa.toString());
        EmpresaDAO empresadao = new EmpresaDAO();
        empresadao.insert(empresa);
        
        //query
        empresadao.query(empresa);
        empresa.setCodigoEmpresa(1);
        empresa=empresadao.query(empresa);
        System.out.println(empresa.toString());
        
        //select
        empresadao.select();
        empresa.setCodigoEmpresa(4);
        empresa = empresadao.query(empresa);
        System.out.println(empresa.toString());
        
        //delete
        Empresa empresaEliminar = new Empresa();
        empresa.setCodigoEmpresa(13);
        empresa = empresadao.query(empresa);
        empresadao.delete(empresa);
        System.out.println(empresa.toString());
        
        //update
        empresa.setCodigoEmpresa(16); 
        empresa = empresadao.query(empresa); 
        empresa.setNombreEmpresa("Grindells");
        empresadao.update(empresa); 
        System.out.println(empresa.toString());
                
    }
}
