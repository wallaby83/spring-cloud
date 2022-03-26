package kr.wallaby.catalogservice.controller;

import kr.wallaby.catalogservice.jpa.CatalogEntity;
import kr.wallaby.catalogservice.service.CatalogService;
import kr.wallaby.catalogservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;
    private final Environment env;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Catalog Service on port %s.", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        Iterable<CatalogEntity> catalogList = this.catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogList.forEach(v -> result.add(new ModelMapper().map(v, ResponseCatalog.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
