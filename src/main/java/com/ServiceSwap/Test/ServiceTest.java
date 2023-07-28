//package com.ServiceSwap.Test;
//
//import com.ServiceSwap.Model.Service;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ServiceTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testServiceMapping() {
//        // given
//        Service service = new Service();
//        service.setNameService("Test Service");
//        service.setDescription("This is a test service");
//        service.setImgService(new byte[] {1, 2, 3});
//        service.setPriceService(100.0);
//        service.setType("Test Type");
//        service.setStatus("Active");
//
//        // when
//        Service savedService = entityManager.persistAndFlush(service);
//
//        // then
//        Assertions.assertThat(savedService.getServiceId()).isNotNull();
//        Assertions.assertThat(savedService.getNameService()).isEqualTo("Test Service");
//        Assertions. assertThat(savedService.getDescription()).isEqualTo("This is a test service");
//        Assertions. assertThat(savedService.getImgService()).isEqualTo(new byte[] {1, 2, 3});
//        Assertions.  assertThat(savedService.getPriceService()).isEqualTo(100.0);
//        Assertions.  assertThat(savedService.getType()).isEqualTo("Test Type");
//        Assertions.  assertThat(savedService.getStatus()).isEqualTo("Active");
//    }
//}
