# Sales Manager Web Page

Web page of the sales-manager architecture
  
 * **Architecture:**
 
    ![Alt text](https://user-images.githubusercontent.com/51386403/99865172-a9d73f00-2b86-11eb-8b75-aa8b54637b19.png "Architecture")
    * 1 - Will receive an order and check if stock is available;
    * 2 - If has stock, will create the order and persist on MongoDB with status ***PROCESSING_PAYMENT***;
    * 3 - The persisted order will be produced on ***NEW_ORDER*** Kafka topic;
    * 4 - Will listen to the topic and check if the customer has available balance;
    * 5 - Will produce a message on ***ORDER_STATUS_CHANGE*** Kafka topic updating the order status (***APPROVED*** or ***CANCELLED***);
    * 6 - Will listen to the topic, update the order status to ***PREPARING_FOR_SHIPPING*** (if order was ***APPROVED***)  and produce a message with the changes in the order;
    * 7 - Will listen to the topic and update the order status on MongoDB;
    * 8 - Will update the product stock (if order was ***APPROVED***);
    * 9 - Occasionally will produce messages as the order status changes and persist the changes on MongoDB.
