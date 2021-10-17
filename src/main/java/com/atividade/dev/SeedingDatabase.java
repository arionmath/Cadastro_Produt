package com.atividade.dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.atividade.dev.models.ModelMarca;
import com.atividade.dev.models.ModelProduto;
import com.atividade.dev.repositories.RepositoryMarca;
import com.atividade.dev.repositories.RepositoryProduto;

@Component
public class SeedingDatabase implements CommandLineRunner {
	
		@Autowired
		RepositoryProduto RP;
		@Autowired
		RepositoryMarca RM;

	@Override
	public void run(String... args) throws Exception {
		
		ModelMarca a = new ModelMarca(null,"brazil pc");
		ModelMarca b = new ModelMarca(null,"toshiba");
		ModelMarca c = new ModelMarca(null,"positivo");
	
		RM.saveAll(Arrays.asList(a,b,c));
		
		RP.saveAll(
				Arrays.asList(
						new ModelProduto(null, "Produto 1", 14.09, a),
						new ModelProduto(null, "Produto 2", 14.99, a),
						new ModelProduto(null, "Produto 3", 14.99, b),
						new ModelProduto(null, "Produto 4", 14.99, b),
						new ModelProduto(null, "Produto 5", 14.99, c),
						new ModelProduto(null, "Produto 6", 14.99, c)
						)
				);
		
	}

}
