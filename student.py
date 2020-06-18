class student:
	def __init__(self,name,age):
		self.name = name
		self.age = age 
	def __str__(self):
		return self.name+" "+str(self.age)
	def avg(self):
		return self.age/2
def main():
	s1 = student('akhil',22)
	print(s1.avg())
	s2 = student('surya',25)
	print(s2.avg())
if __name__ == '__main__':
	main()