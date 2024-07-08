package com.ecommerce.servicess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.CakeOption;
import com.ecommerce.entity.CartIteam;
import com.ecommerce.entity.Chockolate;
import com.ecommerce.entity.DiwaliGifts;
import com.ecommerce.entity.Dryfruites;
import com.ecommerce.entity.Flowers;
import com.ecommerce.entity.Gift;
import com.ecommerce.entity.Others;
import com.ecommerce.entity.Plants;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ChockRpo;
import com.ecommerce.repository.DiwaliRep;
import com.ecommerce.repository.DryfruitRep;
import com.ecommerce.repository.FlowersRep;
import com.ecommerce.repository.GiftRepo;
import com.ecommerce.repository.OthersRep;
import com.ecommerce.repository.PlantsRep;
import com.ecommerce.repository.Productrepository;
import com.ecommerce.repository.UserRep;
@Service
public class AddcartServImp implements AddCartService {
	@Autowired
	private GiftRepo giftRepo;
	@Autowired
	private ChockRpo chockolate;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private Productrepository productrepository;
	@Autowired
	private UserRep users;
	
	@Autowired
	private DryfruitRep dryfruitRep;
	@Autowired
	private PlantsRep plants;
	@Autowired
	private DiwaliRep diwaliGifts;
	@Autowired
	private OthersRep othersRep;
	
	@Autowired
	private FlowersRep flowersRep;
	@Override
	public String choSave(Chockolate product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Chockolate savedProduct = chockolate.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	}

	@Override
	public String giftSave(Gift product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Gift savedProduct = giftRepo.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	
	}

	@Override
	public String addCart(int quant, Long userId, Long choId) {
		return null;
//		 Optional<User> userOptional = users.findById(userId);
//	       
//	        Optional<Chockolate> choOptional = chockolate.findById(choId);
//	  
//	        
//	        if (userOptional.isPresent() &&choOptional.isPresent()) {
//	            User user = userOptional.get();
//	           Gift g= new Gift();
//	            Chockolate chockolate2 = choOptional.get();
//	          
//
//	            // Step 2: Check if the product quantity is sufficient
//	            if (chockolate2.getQuantityAvailable() < quant) {
//	                return "Insufficient quantity available for " + chockolate2.getProductName();
//	            }
//
//	            // Step 3: Check if the item is already in the user's cart
//	           
//	            Optional<CartIteam> findByChockolateAndGift = cartRepository.findByUserAndChockolate(user, chockolate2);
//
//	            if (findByChockolateAndGift.isPresent()) {
//	                // Update quantity if item already exists in cart
//	               
//	             
//	                CartIteam cartIteam = findByChockolateAndGift.get();
//	                cartIteam.setQuantity(cartIteam.getQuantity());
//	            } else {
//	                // Create a new cart item
//	                CartIteam newCartItem = new CartIteam();
//	                newCartItem.setUser(user);
//	                newCartItem.setQuantity(quant);
//	               
//	                cartRepository.save(newCartItem);
//	            }
//
//	            return "Item(s) added to cart successfully";
//	        } else {
//	            return "User or product not found";
//	        }
	}

	@Override
	public List<Chockolate> getAllCho() {
		List<Chockolate> findAll = chockolate.findAll();
		return findAll;
	}

	@Override
	public List<Gift> getAllGift() {
		// TODO Auto-generated method stub
		List<Gift> findAll = giftRepo.findAll();
		return findAll;
	}

	@Override
	public String DrySave(Dryfruites product, MultipartFile imageFile) {
		// TODO Auto-generated method stub
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Dryfruites savedProduct = dryfruitRep.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	
		
	}

	@Override
	public String plantSave(Plants product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Plants savedProduct = plants.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	}

	@Override
	public List<Plants> getAllplant() {
		List<Plants> findAll = plants.findAll();
		return findAll;
	}

	@Override
	public List<Dryfruites> getAllDry() {
		// TODO Auto-generated method stub
		List<Dryfruites> findAll = dryfruitRep.findAll();
		return findAll;
	}

	@Override
	public String DivSave(DiwaliGifts product, MultipartFile imageFile) {
		// TODO Auto-generated method stub
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            DiwaliGifts savedProduct = diwaliGifts.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	}

	@Override
	public String OtherSave(Others product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Others savedProduct = othersRep.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	}

	@Override
	public List<DiwaliGifts> getAllDiwali() {
		
		return diwaliGifts.findAll();
	}

	@Override
	public List<Others> getAllOthers() {
		// TODO Auto-generated method stub
		return othersRep.findAll();
	}

	@Override
	public String flowerSave(Flowers product, MultipartFile imageFile) {
		try {
            // Set product details
            product.setImageData(imageFile.getBytes());

            // Create CakeFlavor entities and associate them with the product
         

            // Save the product with flavors
            Flowers savedProduct = flowersRep.save(product);

            if (savedProduct.getId() != null) {
                return "Product saved successfully";
            } else {
                return "Failed to save product";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to process image";
        }
	
	}

	@Override
	public List<Flowers> getAllFlowers() {
		// TODO Auto-generated method stub
		return flowersRep.findAll();
	}

}
