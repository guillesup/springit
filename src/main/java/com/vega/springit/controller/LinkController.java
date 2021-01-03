package com.vega.springit.controller;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/link")
public class LinkController {

  private final LinkRepository linkRepository;

  public LinkController(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  @GetMapping("/")
  public List<Link> list() {
    return this.linkRepository.findAll();
  }

  @PostMapping("/create")
  public Link create(@ModelAttribute Link link) {
    return this.linkRepository.save(link);
  }

  @GetMapping("/{id}")
  public Optional<Link> read(@PathVariable Long id) {
    return this.linkRepository.findById(id);
  }

  @PutMapping("/{id}")
  public Link update(@ModelAttribute Link link) {
    return this.linkRepository.save(link);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    this.linkRepository.deleteById(id);
  }
}
