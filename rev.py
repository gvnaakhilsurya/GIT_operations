def main():
	s = "abcdefghijk"
	res = ""
	for i in range(0,len(s),3):
		words = s[i:i+3]
		# print(words)
		newWords = words[::-1]
		# print(newWords)
		res = res +newWords
	print(res)

if __name__ == '__main__':
	main()