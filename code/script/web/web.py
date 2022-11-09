# import module
from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import codecs
import os

#from webdriver_manager.firefox import GeckoDriverManager
 

  
# Create the webdriver object. Here the 
# chromedriver is present in the driver 
# folder of the root directory.
driver = webdriver.Chrome(r"./chromedriver")
#driver = webdriver.Firefox(executable_path = GeckoDriverManager().install())  
  
# get https://www.geeksforgeeks.org/
driver.get("https://www.albany.edu/registrar/schedule-classes?user=0009")
  
# Maximize the window and let code stall 
# for 10s to properly maximise the window.
driver.maximize_window()
time.sleep(3)
  
# Obtain button by link text and click.
button = driver.find_element(By.ID,"submit-button-row")
button.submit()

hrtag = driver.find_elements(By.TAG_NAME, "hr")
for hr in hrtag:
 driver.execute_script("arguments[0].innerHTML = '---';", hr)

#print(driver.find_element(By.XPATH, "/html/body").text)

#get file path to save page
#n=os.path.join(r"C:\Users\16507\Desktop\cs\Python\web","Page.html")
#open file in write mode with encoding
#f = codecs.open(n, "w", "utf−8")
#obtain page source
h = driver.find_element(By.XPATH, "/html/body").text
#write page source content to file
#file.write(h)
with open(r"page.txt", 'w', encoding='utf-8', errors='replace') as docfile:
 docfile.write(h)
 docfile.close()
#close browser
driver.quit()
