//package com.oito.feign;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name = "address", url = "${microservice.url.address-service}")
//public interface AddressProxy {
//	@GetMapping("id/{id}")
//	String getAddressById(@PathVariable int id);
//}
