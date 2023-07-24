package com.ServiceSwap.Service;

import com.ServiceSwap.Model.Seller;
import com.ServiceSwap.Repository.SellerRepository;
import com.ServiceSwap.Repository.ServiceRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Services_Service {
    private final ServiceRepository serviceRepository;
    private final SellerRepository sellerRepository;

    public Services_Service(ServiceRepository serviceRepository, SellerRepository sellerRepository) {
        this.serviceRepository = serviceRepository;
        this.sellerRepository = sellerRepository;
    }
    public List<String> getData(){
        return serviceRepository.allServiceData();
    }
    public com.ServiceSwap.Model.Service registerService(com.ServiceSwap.Model.Service service){
        return serviceRepository.save(service);
    }

    public List<com.ServiceSwap.Model.Service> allServices(){
        return serviceRepository.findAll();
    }
    public List<com.ServiceSwap.Model.Service> getByType(String type){
        return serviceRepository.findByType(type);
    }
    public List<com.ServiceSwap.Model.Service> getServices(String name,String city,String type){
        return serviceRepository.findByCityAndTypeAndName(name,city,type);
    }
    public Optional<com.ServiceSwap.Model.Service> getService(Integer id){
        return serviceRepository.findById(id);
    }
    public com.ServiceSwap.Model.Service updateService(Integer id) throws ChangeSetPersister.NotFoundException {
        Optional<com.ServiceSwap.Model.Service> optionalService = serviceRepository.findById(id);
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (optionalSeller.isPresent() && optionalService.isPresent()) {
           Seller seller = optionalSeller.get();
            com.ServiceSwap.Model.Service service = optionalService.get();
            if (seller.getId().equals(service.getServiceId())) {
               service.setNameService(service.getNameService());
               service.setImgService(service.getImgService());
               service.setPriceService(service.getPriceService());
               service.setDescription(service.getDescription());
               service.setStatus(service.isStatus());
                return serviceRepository.save(service);
            }
        } else throw new ChangeSetPersister.NotFoundException();

        return null;
    }
    public boolean deleteService(Integer id ){
        Optional<com.ServiceSwap.Model.Service> optionalService =serviceRepository.findById(id);
        if (optionalService.isPresent()){
            com.ServiceSwap.Model.Service service=optionalService.get();
            serviceRepository.delete(service);
            return true;
        }else {
            return false;
        }
    }
}
