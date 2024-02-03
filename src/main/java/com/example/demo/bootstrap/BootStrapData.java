package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository,
                         OutsourcedPartRepository outsourcedPartRepository,
                         InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //dataLoad();

        if (partRepository.count() == 0) {
            dataLoad();
        }

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }

    private void dataLoad() {

        // Example products
        // Custom build computers
        Product computer1 = new Product("High end computer", 1899.99, 3);
        productRepository.save(computer1);

        Product computer2 = new Product("Mid range computer", 1199.99, 3);
        productRepository.save(computer2);

        Product computer3 = new Product("Low cost computer", 699.99, 3);
        productRepository.save(computer3);

        // Laptop computers
        Product laptop1 = new Product("High end laptop", 2199.99, 3);
        productRepository.save(laptop1);

        Product laptop2 = new Product("Mid range laptop", 1499.99, 3);
        productRepository.save(laptop2);

        // Warranty options
        Product warranty1 = new Product("Basic Warranty", 0.0, 99);
        productRepository.save(warranty1);

        Product warranty2 = new Product("Love-it Guarantee (Extended Warranty)", 149.99, 99);
        productRepository.save(warranty2);


        // Example parts
        // Inhouse parts
        // warranty options
        InhousePart premiumWarranty = new InhousePart();
        premiumWarranty.setName("Love-it Guarantee (Extended Warranty)");
        premiumWarranty.setPrice(149.99);
        premiumWarranty.setInv(999);
        premiumWarranty.setPartId(1);
        premiumWarranty.setProducts(new HashSet<>(List.of(warranty2)));
        premiumWarranty.setMin(997);
        premiumWarranty.setMax(999);
        inhousePartRepository.save(premiumWarranty);

        InhousePart basicWarranty = new InhousePart();
        basicWarranty.setName("Basic Warranty");
        basicWarranty.setPrice(0.0);
        basicWarranty.setInv(999);
        basicWarranty.setPartId(2);
        basicWarranty.setProducts(new HashSet<>(List.of(warranty1)));
        basicWarranty.setMin(997);
        basicWarranty.setMax(999);
        inhousePartRepository.save(basicWarranty);

        // Outsourced parts
        // CPU options
        OutsourcedPart premiumCPU = new OutsourcedPart();
        premiumCPU.setName("5GHz octo-core CPU");
        premiumCPU.setPrice(699.99);
        premiumCPU.setInv(10);
        premiumCPU.setCompanyName("MicroTronics Direct");
        premiumCPU.setProducts(new HashSet<>(List.of(computer1)));
        premiumCPU.setMin(3);
        premiumCPU.setMax(10);
        outsourcedPartRepository.save(premiumCPU);

        OutsourcedPart budgetCPU = new OutsourcedPart();
        budgetCPU.setName("2GHz dual-core CPU");
        budgetCPU.setPrice(149.99);
        budgetCPU.setInv(10);
        budgetCPU.setCompanyName("MicroTronics Direct");
        budgetCPU.setProducts(new HashSet<>(List.of(computer2, computer3)));
        budgetCPU.setMin(3);
        budgetCPU.setMax(10);
        outsourcedPartRepository.save(budgetCPU);

        // RAM options
        OutsourcedPart ultraRAM = new OutsourcedPart();
        ultraRAM.setName("32GB Fast RAM");
        ultraRAM.setPrice(229.95);
        ultraRAM.setInv(10);
        ultraRAM.setCompanyName("MicroTronics Direct");
        ultraRAM.setProducts(new HashSet<>(List.of(computer1, computer2)));
        ultraRAM.setMin(3);
        ultraRAM.setMax(10);
        outsourcedPartRepository.save(ultraRAM);

        OutsourcedPart stableRAM = new OutsourcedPart();
        stableRAM.setName("16GB LC RAM");
        stableRAM.setPrice(95.49);
        stableRAM.setInv(10);
        stableRAM.setCompanyName("MicroTronics Direct");
        stableRAM.setProducts(new HashSet<>(List.of(computer3)));
        stableRAM.setMin(3);
        stableRAM.setMax(10);
        outsourcedPartRepository.save(stableRAM);

        // Disk drive options
        OutsourcedPart solidStateDrive = new OutsourcedPart();
        solidStateDrive.setName("2TB SSD");
        solidStateDrive.setPrice(189.95);
        solidStateDrive.setInv(10);
        solidStateDrive.setCompanyName("MicroTronics Direct");
        solidStateDrive.setProducts(new HashSet<>(List.of(computer1, computer2)));
        solidStateDrive.setMin(3);
        solidStateDrive.setMax(10);
        outsourcedPartRepository.save(solidStateDrive);

        OutsourcedPart hardDiskDrive = new OutsourcedPart();
        hardDiskDrive.setName("3TB HDD");
        hardDiskDrive.setPrice(109.95);
        hardDiskDrive.setInv(10);
        hardDiskDrive.setCompanyName("MicroTronics Direct");
        hardDiskDrive.setProducts(new HashSet<>(List.of(computer3)));
        hardDiskDrive.setMin(3);
        hardDiskDrive.setMax(10);
        outsourcedPartRepository.save(hardDiskDrive);

        // Motherboard options
        OutsourcedPart motherboardATX = new OutsourcedPart();
        motherboardATX.setName("Socket 1254 ATX motherboard");
        motherboardATX.setPrice(329.99);
        motherboardATX.setInv(10);
        motherboardATX.setCompanyName("MicroTronics Direct");
        motherboardATX.setProducts(new HashSet<>(List.of(computer1)));
        motherboardATX.setMin(3);
        motherboardATX.setMax(10);
        outsourcedPartRepository.save(motherboardATX);

        OutsourcedPart motherboardAIO = new OutsourcedPart();
        motherboardAIO.setName("All in one motherboard");
        motherboardAIO.setPrice(119.95);
        motherboardAIO.setInv(10);
        motherboardAIO.setCompanyName("MicroTronics Direct");
        motherboardAIO.setProducts(new HashSet<>(List.of(computer2, computer3)));
        motherboardAIO.setMin(3);
        motherboardAIO.setMax(10);
        outsourcedPartRepository.save(motherboardAIO);

        // Chassis options
        OutsourcedPart tower = new OutsourcedPart();
        tower.setName("ATX mega tower");
        tower.setPrice(239.99);
        tower.setInv(10);
        tower.setCompanyName("MicroTronics Direct");
        tower.setProducts(new HashSet<>(List.of(computer1)));
        tower.setMin(3);
        tower.setMax(10);
        outsourcedPartRepository.save(tower);

        OutsourcedPart microDesk = new OutsourcedPart();
        microDesk.setName("MicroATX desktop chassis");
        microDesk.setPrice(114.95);
        microDesk.setInv(2);
        microDesk.setCompanyName("MicroTronics Direct");
        microDesk.setProducts(new HashSet<>(List.of(computer2, computer3)));
        microDesk.setMin(2);
        microDesk.setMax(3);
        outsourcedPartRepository.save(microDesk);
    }
}
