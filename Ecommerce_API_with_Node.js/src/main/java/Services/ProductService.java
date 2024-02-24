package Services;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import Models.Product;
import dao.ProductDAO;
import dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	private final ProductDAO productDAO;
    private final Mapper modelMapper;

    @Autowired
    public ProductService(ProductDAO productDAO, Mapper modelMapper) {
        this.productDAO = productDAO;
        this.modelMapper = modelMapper;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productDAO.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long productId) {
        Product product = productDAO.findById(productId);
        return convertToDTO(product);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productDAO.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product existingProduct = productDAO.findById(productId);
        existingProduct.setTitle(productDTO.getTitle());
        // update other fields
        Product updatedProduct = productDAO.save(existingProduct);
        return convertToDTO(updatedProduct);
    }

    public void deleteProduct(Long productId) {
        productDAO.deleteById(productId);
    }

    private ProductDTO convertToDTO(Product product) {
        return modelMapper(product, ProductDTO.class);
    }

    private ProductDTO modelMapper(Product product, Class<ProductDTO> class1) {
		
		return null;
	}

	private Product convertToEntity(ProductDTO productDTO) {
        return modelMapper(productDTO, Product.class);
    }

	private Product modelMapper(ProductDTO productDTO, Class<Product> class1) {
		
		return null;
	}
	
}
