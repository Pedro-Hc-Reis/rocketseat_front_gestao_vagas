package br.com.rocketseat.front_gestao_vagas.modules.company.service;

import br.com.rocketseat.front_gestao_vagas.modules.company.dto.CreateJobsDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateJobService {

    public String execute ( CreateJobsDTO jobs , String token ) {
        RestTemplate rt = new RestTemplate ( );
        HttpHeaders headers = new HttpHeaders ( );
        headers.setContentType ( MediaType.APPLICATION_JSON );
        headers.setBearerAuth ( token );

        HttpEntity<CreateJobsDTO> request = new HttpEntity<> ( jobs , headers );

        return rt.postForObject ( "http://localhost:8080/company/job/" , request , String.class );
    }
}