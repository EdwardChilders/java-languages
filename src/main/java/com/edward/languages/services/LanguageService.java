package com.edward.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edward.languages.models.Language;
import com.edward.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	public Language createLanguage(Language l) {
		return languageRepository.save(l)
;	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
			return null;
		}
	}
	public Language updateLanguage(Long id, String name, String creator, Double version) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			optionalLanguage.get().setName(name);
			optionalLanguage.get().setCreator(creator);
			optionalLanguage.get().setVersion(version);
			return languageRepository.save(optionalLanguage.get());
		}else {
			return null;
		}
	}
	public void deleteLanguage(Long id) {
		if(languageRepository.findById(id).isPresent()) {
			languageRepository.deleteById(id);
		}
	}
}
