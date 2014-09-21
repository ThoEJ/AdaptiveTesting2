package at.reisisoft.jku.ce.adaptivelearning.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import at.reisisoft.jku.ce.adaptivelearning.core.AnswerStorage;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class XmlQuestionData<DataStorage extends AnswerStorage>
implements Serializable {

	private static final long serialVersionUID = 5422318817914536294L;
	@XmlElement(name = "dataStorage", nillable = true)
	private DataStorage dataStorage;
	@XmlElement(name = "question")
	private String question;
	@XmlElement(name = "difficulty")
	private float difficulty;

	public XmlQuestionData() {
		this(null, "", 0);
	}

	@SuppressWarnings("unchecked")
	public XmlQuestionData(DataStorage dataStorage, String question,
			float difficulty) {
		if (dataStorage == null) {
			dataStorage = getEmptyDataStorage();
		}
		this.dataStorage = dataStorage;
		this.difficulty = difficulty;
		if (question == null || question.length() == 0) {
			question = "";
		}
		this.question = question;

	}

	public DataStorage getDataStorage() {
		return dataStorage;
	}

	public void setDataStorage(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}

	public abstract DataStorage getEmptyDataStorage();

	// public static void main(String[] args) throws JAXBException {
	// ByteArrayOutputStream byteArrayOutputStream = new
	// ByteArrayOutputStream();
	// JAXBContext context = JAXBContext.newInstance(XMLQuestionData.class);
	// Marshaller marshaller = context.createMarshaller();
	// marshaller.marshal(new XMLQuestionData(), byteArrayOutputStream);
	// System.out.println(new String(byteArrayOutputStream.toByteArray()));
	// }

}
