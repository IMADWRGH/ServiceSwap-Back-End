package com.ServiceSwap.Service;


import com.ServiceSwap.Model.Service;
import org.springframework.data.crossstore.ChangeSetPersister;


import java.util.List;
import java.util.Optional;

public interface ServicesService {


     List<String> getData();
    Service registerService(Service service);

     List<Service> allServices();
     List<Service> getByType(String type);
     List<Service> getServices(String name,String city,String type);
     Optional<Service> getService(Integer id);
     Service updateService(Integer id) throws ChangeSetPersister.NotFoundException;
     boolean deleteService(Integer id );
}
