package kr.wallaby.catalogservice.service;

import kr.wallaby.catalogservice.jpa.CatalogEntity;
import kr.wallaby.catalogservice.jpa.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return this.catalogRepository.findAll();
    }
}
