data=check(x)
for item in data:
    item['Similarity'] = float(item['Similarity'])
print(json.dumps(data, indent=4))