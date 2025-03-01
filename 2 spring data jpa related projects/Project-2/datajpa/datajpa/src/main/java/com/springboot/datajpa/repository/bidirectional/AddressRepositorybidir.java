package com.springboot.datajpa.repository.bidirectional;

import com.springboot.datajpa.model.bidirectionalmapping.Addressbidir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositorybidir extends JpaRepository<Addressbidir, Long> {
}
