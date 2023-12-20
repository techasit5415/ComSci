guest_list = ("Cage Fred Maxwell John GUIDO").split()
query_name = input("Enter the name to search for: ")
if query_name in guest_list:
    print(f"Welcome, you're on the list! {query_name.capitalize()}")
else:
    print ("Enter query name and guest list :", guest_list)
    print("--- searching ---")
    print(f"Sorry, you're not on the list! {query_name.capitalize()}")
