package com.ProjetoCpf.buscacpf;

import com.ProjetoCpf.buscacpf.controller.PessoaController;
import com.ProjetoCpf.buscacpf.entity.Pessoa;
import com.ProjetoCpf.buscacpf.service.PessoaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class BuscacpfApplicationTests {
        
    private MockMvc mockMvc;
    private PessoaService pessoaService;
    
        @BeforeEach
        void configurarMockMvc(){
            
            pessoaService = Mockito.mock(PessoaService.class);
            
            PessoaController pessoaController = new PessoaController(pessoaService);
            
            mockMvc = MockMvcBuilders
                    .standaloneSetup(pessoaController)
                    .build();
        }
        @Test
        void falsoBuscaCpf()  throws Exception {
            
            Pessoa pessoa = new Pessoa();
            
            pessoa.setCpf("11111111111");
            pessoa.setNome("Joao Silva");
            
            Mockito.when(
                pessoaService.buscaPorCpf("11111111111")
                
            ).thenReturn(java.util.Optional.of(pessoa));
                
            
            mockMvc.perform(
                        get("/pessoa/cpf")
                            .param("cpf","11111111111")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf").value("11111111111"))
                .andExpect(jsonPath("$.nome").value("Joao Silva"));
                
            
            
        }
	@Test        
	void contextLoads() {
	}

}
