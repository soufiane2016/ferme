package com.projet.ferme.mapper;

import com.projet.ferme.domain.Transport;
import com.projet.ferme.dto.TransportDto;
import org.springframework.stereotype.Service;

@Service
public class TransportMapper {
    public Transport TransportFromDto(TransportDto transportDto) {
        Transport transport = new Transport();
        transport.setId(transportDto.getId());
        transport.setImmatricule(transportDto.getImmatricule());
        return transport;
    }

    public TransportDto DtoFromTransport(Transport transport) {
        TransportDto transportDto = new TransportDto();
        transportDto.setId(transport.getId());
        transportDto.setImmatricule(transport.getImmatricule());
        return transportDto;
    }
}
