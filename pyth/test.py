from selenium import webdriver
from selenium.webdriver.common import keys
import time

class TwitterBot:
    def __init__(self,username, password):
	 self.username= username
	 self.password= password
	 self.bot= webdriver.Firefox()
	
	def login (self):
        bot=self.botbot.get('https://twitter.com/login')
        time.sleep(6)
        email=bot.find_element_by_class_name('session[username_or_email]')
	    password=bot.find_element_by_name('session[password]')
	    email.clear()
	    password.clear()
        time.sleep(3)
        email.send_keys(self.username)
	    password.send_keys(self.password)
        time.sleep(3)
        password.sendkeys(Keys.RETURN)
	    time.sleep(3)

ed=TwitterBot('truthtriggers@yahoo.com','HumanBeing')
ed.login()