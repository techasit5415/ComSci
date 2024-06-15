#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#define ARRAY_stock 100
#define ARRAY_product 100

typedef struct product{
  char name ;
  float price ;
  int quantity ;
} product ;

typedef struct stock{
  float pen ;
  float pencil ;
  float eraser ;
  float ruler ;
  float notebook ;
  float in_stock[ARRAY_stock] ;
  product product[ARRAY_product] ;
} stock ;

void add_product(stock *s){
  printf("Enter the name of the product : ") ;
  scanf("%s", &s->product[0].name) ;
  printf("Enter the price of the product : ") ;
  scanf("%f", &s->product[0].price) ;
  printf("Enter the quantity of the product : ") ;
  scanf("%d", &s->product[0].quantity) ;
}

void calculate_product(stock *s){
  s->pen += s->pen ;
}

int main(void){
  stock s ;
  
  calculate_product(&s) ;
  
  add_product(&s) ;
  
  printf("%f", s.pen) ;
  return 0 ;
}