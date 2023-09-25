import requests
import json
text_to_check = input("[!] Enter text to check : ")
burp0_url = "https://papersowl.com:443/plagiarism-checker-send-data"
burp0_headers = {"User-Agent": "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:100.0) Gecko/20100101 Firefox/100.0", "Accept": "*/*", "Accept-Language": "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3", "Accept-Encoding": "gzip, deflate", "Referer": "https://papersowl.com/free-plagiarism-checker", "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8", "X-Requested-With": "XMLHttpRequest", "Origin": "https://papersowl.com", "Dnt": "1", "Sec-Fetch-Dest": "empty", "Sec-Fetch-Mode": "no-cors", "Sec-Fetch-Site": "same-origin", "Pragma": "no-cache", "Cache-Control": "no-cache", "Te": "trailers", "Connection": "close"}
burp0_data = {"is_free": "false", "plagchecker_locale": "en", "product_paper_type": "1", "title": '', "text": str(text_to_check)}
r = requests.post(burp0_url, headers=burp0_headers, data=burp0_data)
result = json.loads(r.text)
print("\n[!] Word count : " + str(result["words_count"]))
print("\n[!] Turnitin index : " + str(100 - float(result["percent"])))
print("\n[!] Matches : " + str(result["matches"]))