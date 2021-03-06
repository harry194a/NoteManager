package com.hb.platform.notemanager.repository;

import com.hb.platform.notemanager.domain.address.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {


}
