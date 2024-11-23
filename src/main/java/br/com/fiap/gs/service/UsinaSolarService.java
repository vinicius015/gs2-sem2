package br.com.fiap.gs.service;

import br.com.fiap.gs.model.UsinaSolar;
import br.com.fiap.gs.repository.UsinaSolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsinaSolarService {

    @Autowired
    private UsinaSolarRepository usinaSolarRepository;

    public List<UsinaSolar> list() {
        return usinaSolarRepository.findAll();
    }

    public UsinaSolar save(UsinaSolar usinaSolar) {
        return usinaSolarRepository.save(usinaSolar);
    }

    public boolean existsById(Long id) {
        return usinaSolarRepository.existsById(id);
    }

    public void delete(Long id) {
        usinaSolarRepository.deleteById(id);
    }

    public Optional<UsinaSolar> findById(Long id) {
        return usinaSolarRepository.findById(id);
    }
}