package hu.szte.vizz.task;

import hu.szte.vizz.persistence.repository.user.EmailActivationTokenRepository;
import hu.szte.vizz.persistence.repository.user.ForgottenPasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * Automatic token purge task.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
@Service
@Transactional
public class TokensPurgeTask {

    /**
     * Repository of email activation tokens.
     */
    private final EmailActivationTokenRepository emailActivationTokenRepository;

    /**
     * Repository of forgotten password tokens.
     */
    private final ForgottenPasswordTokenRepository forgottenPasswordTokenRepository;

    @Autowired
    public TokensPurgeTask(EmailActivationTokenRepository emailActivationTokenRepository, ForgottenPasswordTokenRepository forgottenPasswordTokenRepository) {
        this.emailActivationTokenRepository = emailActivationTokenRepository;
        this.forgottenPasswordTokenRepository = forgottenPasswordTokenRepository;
    }

    /**
     * Deletes all token which are expired.
     */
    @Scheduled(cron = "${purge.cron.expression}")
    public void purgeExpired() {
        Date now = Date.from(Instant.now());

        emailActivationTokenRepository.deleteAllByExpiryDateBefore(now);
        forgottenPasswordTokenRepository.deleteAllByExpiryDateBefore(now);
    }
}
