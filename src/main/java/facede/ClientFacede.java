/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facede;

import com.mycompany.rentacar.DTO.ClientDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author afons
 */
@Service
public class ClientFacede {
    private static final Map<Long, ClientDTO> clients = new HashMap<>();
    
    public ClientDTO create(ClientDTO clientDTO)
    {
       Long nextId = clients.keySet().size() + 1L;
       clientDTO.setId(nextId);
       clients.put(nextId, clientDTO);
       return clientDTO;
    }
    
    public ClientDTO update (ClientDTO clientDTO, Long id)
    {
        clients.put(id, clientDTO);
        return clientDTO;
    }
    
    public ClientDTO getById(Long id)
    {
        return clients.get(id);
    }
    
    public List<ClientDTO> getAll ()
    {
        return new ArrayList<>(clients.values());
    }
    
    public ClientDTO delete (Long id)
    {
        return clients.remove(id);
    }
}
