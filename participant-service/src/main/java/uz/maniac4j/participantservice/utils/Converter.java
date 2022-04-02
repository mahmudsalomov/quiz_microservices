package uz.maniac4j.participantservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.maniac4j.participantservice.participant.Participant;
import uz.maniac4j.participantservice.participant.ParticipantDto;

@Component
public class Converter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static Participant toParticipant(ParticipantDto dto){
        return Participant
                .builder()
                .organizationId(dto.getOrganizationId())
                .active(dto.isActive())
                .email(dto.getEmail())
                .fio(dto.getFio())
                .username(dto.getUsername())
                .phone(dto.getPhone())
                .build();
    }

    public static ParticipantDto toParticipantDto(Participant participant){
        return ParticipantDto
                .builder()
                .organizationId(participant.getOrganizationId())
                .active(participant.isActive())
                .email(participant.getEmail())
                .fio(participant.getFio())
                .username(participant.getUsername())
                .phone(participant.getPhone())
                .build();
    }

}
