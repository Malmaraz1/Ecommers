package com.example.ecommerce.Service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.Model.Categoria;
import com.example.ecommerce.Model.Dto.Request.CategoriaRequestDto;
import com.example.ecommerce.Repository.RepositorioCategoria;

public interface ServicioCategoriaImp {
   

    Categoria categoriaNueva(CategoriaRequestDto categoriaRequestDto);
        
    
     

    

}
