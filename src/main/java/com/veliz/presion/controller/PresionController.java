package com.veliz.presion.controller;

import com.sun.istack.NotNull;
import com.veliz.presion.dto.PresionDTO;
import com.veliz.presion.dto.response.ResponseDTO;
import com.veliz.presion.service.PresionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static com.veliz.presion.utils.Constants.PRESION_DELETED;
import static com.veliz.presion.utils.Constants.ResponseConstant.SUCCESS;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://presion-react.vercel.app/", "https://presion-react-git-master-erivelk.vercel.app/", "https://presion-react-erivelk.vercel.app/"})
@RequestMapping(value = "presion")
public class PresionController {
    @Autowired
    PresionService presionService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDTO<PresionDTO>> createPresion(@RequestBody PresionDTO presionDTO){
        ResponseDTO<PresionDTO> responseDTO = new ResponseDTO<>(SUCCESS.getDescription(), LocalDateTime.now().toString(), presionService.createPresion(presionDTO));
        return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<ResponseDTO<PresionDTO>> editPresion(@RequestBody PresionDTO presionDTO){
        ResponseDTO<PresionDTO> responseDTO = new ResponseDTO<>(SUCCESS.getDescription(), LocalDateTime.now().toString(), presionService.updatePresion(presionDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<ResponseDTO> deletePresion(@NotNull @PathVariable Long id){
        presionService.deletePresion(id);
        ResponseDTO responseDTO = new ResponseDTO(SUCCESS.getDescription(), LocalDateTime.now().toString(), PRESION_DELETED);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseDTO<List<PresionDTO>>> listPresion(){
        ResponseDTO<List<PresionDTO>> listResponseDTO = new ResponseDTO<>(SUCCESS.getDescription(), LocalDateTime.now().toString(), presionService.listPresion());
        return new ResponseEntity<>(listResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO<PresionDTO>> getPresion(@NotNull @PathVariable Long id){
        ResponseDTO<PresionDTO> presionDTO = new ResponseDTO<>(SUCCESS.getDescription(), LocalDateTime.now().toString(), presionService.getPresion(id));
        return new ResponseEntity<>(presionDTO, HttpStatus.OK);
    }
}
