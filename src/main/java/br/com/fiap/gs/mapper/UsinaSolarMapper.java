package br.com.fiap.gs.mapper;

import br.com.fiap.gs.dtos.UsinaSolarRequestUpdateDto;
import br.com.fiap.gs.dtos.UsinaSolarResponseDto;
import br.com.fiap.gs.dtos.UsinaSolarRequestCreateDto;
import br.com.fiap.gs.model.UsinaSolar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsinaSolarMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UsinaSolarResponseDto toDto(UsinaSolar usinaSolar) {
        return modelMapper.map(usinaSolar, UsinaSolarResponseDto.class);
    }

    public UsinaSolar toModel(UsinaSolarRequestCreateDto dto) {
        return modelMapper.map(dto, UsinaSolar.class);
    }

    public UsinaSolar toModel(Long id, UsinaSolarRequestUpdateDto dto) {
        UsinaSolar result = modelMapper.map(dto, UsinaSolar.class);
        result.setId(id);
        return result;
    }

}
