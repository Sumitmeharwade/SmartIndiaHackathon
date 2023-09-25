import pandas as pd
import numpy as np
from nltk.corpus import stopwords
import nltk
import json
nltk.download('stopwords')
import re
from sklearn.feature_extraction.text import TfidfVectorizer 
from sklearn.metrics.pairwise import cosine_similarity
from sentence_transformers import SentenceTransformer
sbert_model = SentenceTransformer('bert-base-nli-mean-tokens')



def most_similar(doc_id,similarity_matrix,matrix,documents_df):

    print ('Similar Documents:')
    result_list = []
    if matrix=='Cosine Similarity':
        similar_ix=np.argsort(similarity_matrix[doc_id])[::-1]
    elif matrix=='Euclidean Distance':
        similar_ix=np.argsort(similarity_matrix[doc_id])
    for ix in similar_ix:
        if ix==doc_id:
            continue
        document_info = {
        "Document": documents_df.iloc[ix]["documents"],
        "Similarity": similarity_matrix[doc_id][ix]
        }
        result_list.append(document_info)
        
        return result_list




def check(documents):
    documents_df=pd.DataFrame(documents,columns=['documents'])
    stop_words_l=stopwords.words('english')
    documents_df['documents_cleaned']=documents_df.documents.apply(lambda x: " ".join(re.sub(r'[^a-zA-Z]',' ',w).lower() for w in x.split() if re.sub(r'[^a-zA-Z]',' ',w).lower() not in stop_words_l) )
    document_embeddings = sbert_model.encode(documents_df['documents_cleaned'])
    pairwise_similarities=cosine_similarity(document_embeddings)
    return(most_similar(0,pairwise_similarities,'Cosine Similarity',documents_df))

x=[
    '''In recent years, there has been significant progress in 
    the field of renewable energy technologies. Sustainable power 
    sources like solar panels, wind turbines, and hydropower systems have gained momentum as viable alternatives to traditional fossil fuels. These innovations not only reduce our carbon footprint but also 
    contribute to energy security and independence. Moreover, breakthroughs in energy storage solutions are paving the way for a more reliable and efficient green energy grid. 
    As we move forward, continued research and investment in renewable energy will play a pivotal role in mitigating 
    climate change and ensuring a sustainable future for generations to come.''',

    '''The landscape of sustainable power generation has undergone a 
    remarkable transformation in recent times. 
    Clean energy solutions such as photovoltaic cells, wind farms, and hydroelectric 
    dams have emerged as promising options for meeting our energy needs while preserving the environment. 
    These cutting-edge technologies harness the power of nature without depleting finite resources or releasing harmful emissions. 
    Furthermore, innovations in energy storage mechanisms are revolutionizing the way we store and distribute renewable energy. The ongoing pursuit of sustainable power 
    generation is a testament to our commitment to a greener and more resilient energy future.
    ''',

    '''Exploring the depths of our planet's oceans has always been a source of fascination for scientists
    and adventurers alike. The deep-sea environment is a world of its own, filled with mysterious 
    creatures, unique geological formations, and extreme conditions. Scientists aboard research vessels
    equipped with state-of-the-art technology venture into the abyss to unlock the secrets of the deep.
    From bioluminescent creatures that light up the darkness to hydrothermal vents teeming with exotic 
    life forms, the deep sea never ceases to amaze. As we delve deeper into the unknown, we gain a 
    greater understanding of our planet's biodiversity and the potential for 
    new discoveries that lie beneath the waves.

    ''',

    '''Promising alternatives for fulfilling our energy requirements while safeguarding the environment 
    have arisen in the form of clean energy solutions, including photovoltaic cells, wind farms, 
    and hydroelectric dams. These state-of-the-art technologies tap 
    into the forces of nature without exhausting finite resources or emitting harmful pollutants.
    '''
]
# print(check(x))
data=check(x)
for item in data:
    item['Similarity'] = float(item['Similarity'])
print(json.dumps(data, indent=4))

