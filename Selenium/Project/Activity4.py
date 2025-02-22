from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains as builder
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    firstName = "Divya Rukmini"
    lastName = "Mohan Raj"
    
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    #Open Webpage
    driver.get("http://alchemy.hguy.co/orangehrm")

    #check for the title
    pageTitle = driver.title
    print("Title of the page is " + pageTitle)

    # enter credentials : username and password
    driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]").send_keys("orange")
    driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]").send_keys("orangepassword123")
	
	#click submit button
    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()
    
    # Click on PIM
    pim = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewPimModule\"]")
    print("You are on" , pim.text)

    pim.click()

    # Verify that the PIM with employee information has opened
    empInfo = driver.find_element(By.XPATH, "//*[@id=\"employee-information\"]/div[1]/h1").text
    print("You are on " , empInfo)

    #add employee
    addEmp = driver.find_element(By.XPATH, "//*[@id=\"menu_pim_addEmployee\"]")
    
    # add explicit wait until Add button clickable
    wait.until(ExpectedConditions.element_to_be_clickable(addEmp))
    
    #click the Add button
    addEmp.click()
	
    # Verify that the add employee page has opened
    addEmpPage = driver.find_element(By.XPATH, "//*[@id=\"content\"]/div/div[1]/h1").text
    print("You are on " , addEmpPage)

    driver.find_element(By.XPATH, "//*[@id=\"firstName\"]").send_keys(firstName)
    driver.find_element(By.XPATH, "//*[@id=\"lastName\"]").send_keys(lastName)
    	
    driver.find_element(By.XPATH, "//*[@id=\"btnSave\"]").click()
    
    print("New employee" , firstName , lastName, "added")

    # search Employee
    # Find the PIM option in the menu and click it.
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewPimModule\"]").click()
	
    # click on Employee list
    driver.find_element(By.XPATH, "//*[@id=\"menu_pim_viewEmployeeList\"]").click()
	    
    name = firstName + " " + lastName
    print("Searching for employee : " , name)
		
    employeeName = driver.find_element(By.XPATH, "//*[@id=\"empsearch_employee_name_empName\"]")
    employeeName.click()

    # add explicit wait until employee name field is focused
    # wait.until(ExpectedConditions.element_to_be_clickable(employeeName))

    employeeName.send_keys(name)
        
    # add implicit wait after employee details are entered.
    driver.implicitly_wait(10)

    searchData = driver.find_element(By.ID, "searchBtn")
    searchData.click()
    
    # add implicit wait after search button is clicked.
    driver.implicitly_wait(10)

    #validate the retrieved data matches with newly added employee data.
    searchEmployeeFirstName = driver.find_element(By.XPATH, "//*[@id=\"resultTable\"]/tbody/tr/td[3]/a").text
    searchEmployeeLastName = driver.find_element(By.XPATH, "//*[@id=\"resultTable\"]/tbody/tr/td[4]/a").text

    print(searchEmployeeFirstName)
    print(searchEmployeeLastName)

    if searchEmployeeFirstName == firstName :
        print("First Name Matched. Check for Last Name")
        if searchEmployeeLastName == lastName :
            print("Last Name Also Matched. Newly Added employee is on search list.")
        else :
            print("Last Name not Found.")
    else :
        print("Employee Not Found.")
	

    #close the browser
    driver.quit()