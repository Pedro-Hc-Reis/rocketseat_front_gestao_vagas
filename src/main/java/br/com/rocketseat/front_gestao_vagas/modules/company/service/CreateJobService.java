package br.com.rocketseat.front_gestao_vagas.modules.company.service;

import br.com.rocketseat.front_gestao_vagas.modules.company.dto.CreateJobsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateJobService {

    @Value ( "${host.api.gestao.vagas}" )
    private String hostAPIGestaoVagas;

    public String execute ( CreateJobsDTO jobs , String token ) {
        RestTemplate rt = new RestTemplate ( );
        HttpHeaders headers = new HttpHeaders ( );
        headers.setContentType ( MediaType.APPLICATION_JSON );
        headers.setBearerAuth ( token );

        HttpEntity<CreateJobsDTO> request = new HttpEntity<> ( jobs , headers );

        var url = hostAPIGestaoVagas.concat ( "/company/job/" );
        return rt.postForObject ( url , request , String.class );
    }
}