package br.com.rocketseat.front_gestao_vagas.modules.candidate.service;

import br.com.rocketseat.front_gestao_vagas.modules.candidate.dto.JobDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class FindJobsService {

    public List<JobDTO> execute ( String token , String filter ) {
        RestTemplate rt = new RestTemplate ( );
        HttpHeaders headers = new HttpHeaders ( );
        headers.setBearerAuth ( token );
        HttpEntity<Map<String, String>> request = new HttpEntity<> ( headers );
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString ( "http://localhost:8080/candidate/job" )
                .queryParam ( "filter" , filter );

        ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>> ( ) {
        };
        try {
            var result = rt.exchange(builder.toUriString(), HttpMethod.GET, request, responseType);
            return result.getBody();
        } catch (Unauthorized ex) {
            throw new HttpClientErrorException ( HttpStatus.UNAUTHORIZED );
        }
    }
}