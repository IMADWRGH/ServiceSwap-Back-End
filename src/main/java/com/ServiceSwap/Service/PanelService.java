package com.ServiceSwap.Service;

import com.ServiceSwap.Model.Customer;
import com.ServiceSwap.Model.Panel;
import com.ServiceSwap.Repository.PanelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanelService {
    private final PanelRepository panelRepository;

    public PanelService(PanelRepository panelRepository) {
        this.panelRepository = panelRepository;
    }


        public List<Panel> getAllPanels() {
            return panelRepository.findAll();
        }

        public Panel getPanelById(Integer id) {
            return panelRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Panel not found"));
        }

        public Panel createPanel(Panel panel) {
            return panelRepository.save(panel);
        }

        public Panel updatePanel(Integer id, Panel updatedPanel) {
            Panel panel = panelRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Panel not found"));
            if (panel != null) {
                updatedPanel.setPanelId(panel.getPanelId());
                return panelRepository.save(updatedPanel);
            }
            return null;
        }

        public void deletePanel(Integer id) {
            panelRepository.deleteById(id);
        }

        public Customer getCustomerByPanelId(Integer panelId) {
            Panel panel = panelRepository.findById(panelId).orElseThrow(()-> new EntityNotFoundException("Panel not found"));
            if (panel != null) {
                return panel.getCustomer();
            }
            return null;
        }
    }


