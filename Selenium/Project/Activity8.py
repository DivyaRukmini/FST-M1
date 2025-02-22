from threading import Thread
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import ActionChains
from selenium.webdriver.support import expected_conditions as ExpectedConditions
from selenium.webdriver.support.wait import WebDriverWait


#create WebDriver instance
with webdriver.Firefox() as driver:

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)

    builder = ActionChains(driver)

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

    leave = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")
    builder.move_to_element(leave).pause(5).click(leave).pause(5).perform()

    LeaveApply = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[1]/div[1]/h1").text
    print("You are on " + LeaveApply)

    #Click Apply Leave.
    driver.find_element(By.XPATH, "//select[@id='applyleave_txtLeaveType']/option[@value='1']").click()
    driver.implicitly_wait(10)
   

    driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/select/option[2]").click()
    #dayOff = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[1]/select/option[2]").text()
    #print(dayOff)

    driver.find_element(By.XPATH, "//input[@id='applyleave_txtFromDate']").clear()
    driver.find_element(By.XPATH, "//input[@id='applyleave_txtFromDate']").send_keys("2025-02-20")
    
    driver.find_element(By.XPATH, "//input[@id='applyleave_txtToDate']").clear()
    driver.find_element(By.XPATH, "//input[@id='applyleave_txtToDate']").send_keys("2025-02-20")
    
    driver.implicitly_wait(10)

    leaveText = driver.find_element(By.XPATH, "//textarea[@id='applyleave_txtComment']")
    leaveText.clear()
    leaveText.send_keys("1 day off for DR")
   
    driver.implicitly_wait(10)

    driver.find_element(By.XPATH, "//input[@id='applyBtn']").click()
    
    driver.implicitly_wait(10)

    print("Leave applied.")
    
    #Navigate to the My Leave page to check the status of the leave application.
    #Find the “My Leave” menu item and click it.
    
    driver.find_element(By.XPATH, "//a[@id='menu_leave_viewMyLeaveList']").click()
    print("Clicked on My Leave tab")

    #get detail form result table
    #Find the number of columns from header in the table and print them.
    
    cols = driver.find_elements(By.XPATH, "//table[@id='resultTable']/thead/tr/th")
    print("total number of columns in header: " , len(cols))

    #Find the number of rows in the table and print them. 
    row = driver.find_elements(By.XPATH, "//table[@id='resultTable']/tbody/tr")
    print("total number of rows : " , len(row))

    foundFlag = False
    for i in range(1, len(row)+1) : 

        #Find and print all the cell values in the first row of the table.
        path = "//table[@id='resultTable']/tbody/tr[" + str(i) + "]"
        rowData = driver.find_elements(By.XPATH,  path)
        
        print(i, " row cell values: ")
        for cell in rowData:
            print(cell.text)

            #check the comment
            if cell.text.find("1 day off for DR") != -1 :
                print("Records Found.")
                foundFlag = True

                path = "//table[@id='resultTable']/tbody/tr[" + str(i) + "]/td[6]"
                status = driver.find_element(By.XPATH, path)

                print("Current leave status is : " , status.text)
                
        if foundFlag:
            break

        i+=1

    if foundFlag :
        print("Records Found..!!")
    else :
        print("Records not Found..!!")


    #close the browser
    driver.quit()