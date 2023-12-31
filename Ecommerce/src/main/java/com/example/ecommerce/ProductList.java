package com.example.ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ProductList {
    private TableView<Product> productTable;

    public VBox createTable(ObservableList<Product>data){
        //columns
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory((new PropertyValueFactory<>("id")));

        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory((new PropertyValueFactory<>("name")));

        TableColumn price = new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        productTable = new TableView<>();
        productTable.setItems(data);
        productTable.getColumns().addAll(id,name,price);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(productTable);
        return vbox;
    }
    public VBox getAllProducts(){
        ObservableList<Product> data = Product.getAllProducts();
        return createTable(data);
    }
    public Product getSelectedProduct(){
       return productTable.getSelectionModel().getSelectedItem();
    }
    public VBox getProductInCart(ObservableList<Product> data){
        return createTable(data);
    }
}
