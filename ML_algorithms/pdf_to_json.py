import PyPDF2
import json

def pdf_to_json(pdf_file):
    pdf_text = []

    # Open the PDF file in binary mode
    with open(pdf_file, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)

        # Iterate through each page of the PDF
        for page_number in range(len(pdf_reader.pages)):
            page = pdf_reader.pages[page_number]
            pdf_text.append(page.extract_text())

    # Convert the PDF text into JSON
    pdf_json = {'content': pdf_text}

    return pdf_json

if __name__ == "__main__":
    pdf_file = 'C:\\Users\\kusha\\Desktop\\SmartIndiaHackathon\\ML algorithms\\bt_troubleshoot.pdf'  # Replace with your PDF file path
    output_json_file = 'output.json'  # Output JSON file

    pdf_data = pdf_to_json(pdf_file)

    # Save the JSON data to a file
    with open(output_json_file, 'w') as json_file:
        json.dump(pdf_data, json_file, indent=4)

    print(f'PDF content has been converted to JSON and saved to {output_json_file}')
