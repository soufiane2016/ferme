package com.projet.ferme.services;

import com.projet.ferme.domain.Transport;
import com.projet.ferme.dto.TransportDto;
import com.projet.ferme.mapper.TransportMapper;
import com.projet.ferme.repositories.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransportService {
    private TransportRepo transportRepo;
    private TransportMapper transportMapper;

    @Autowired
    public TransportService(TransportRepo transportRepo, TransportMapper transportMapper) {
        this.transportRepo = transportRepo;
        this.transportMapper = transportMapper;
    }

    public Transport addTransport(TransportDto transportDto){
        Transport Transport = transportMapper.TransportFromDto(transportDto);
        return transportRepo.save(Transport);
    }

    public Transport updateTransport(TransportDto transportDto){
        Transport updateTransport = transportMapper.TransportFromDto(transportDto);
        return transportRepo.save(updateTransport);
    }

    public List<TransportDto> getAllTransport(){
        List<Transport> listTransports =  transportRepo.findAll();
        List<TransportDto> transportDtoList = new ArrayList<>();
        listTransports.forEach(transport -> transportDtoList.add(transportMapper.DtoFromTransport(transport)));
        return transportDtoList;
    }
    public Transport getTransportbyId(Long id){
        return transportRepo.findTransportById(id);
    }
    public void deleteTransportById(Long id){
        transportRepo.deleteById(id);
    }
}
